/*
You're setting up a new screen for an app and need to handle network interaction
The network call is setup but this data needs to be handled and passed to the Screen by a Repository
    The method getCatPictures can return a List<String> or throw an exception
    The repository should convert the network data into a DataState based on Success or Failure and return it

The screen should show a loading state while data is being fetched, and dismiss the loading state when finished

The screen returns all actions performed when finished and this log should be tested against expected results
 */

class Screen(val repository: Repository) {
    val screenLogs: MutableList<String> = mutableListOf()

    fun loadPage(): List<String>{
//        Modify here
        showLoading(true)
        val state = repository.getCatPictures()
        when (state) {
            is DataState.Success -> showResults(state.data)
            is DataState.Failed -> showError(state.e)
        }
        showLoading(false)

        return screenLogs
    }

    //    Do not change these are how you interact with the view
    fun showLoading(loading: Boolean) {
        screenLogs.add("Loading: $loading")
    }

    fun showResults(results: List<String>) {
        for(result in results) screenLogs.add("Showing $result")
    }

    fun showError(error: Throwable) {
        screenLogs.add("${error.message}")
    }
}

class Repository(val networkApi: NetworkApi){
//     Modify here

    fun getCatPictures() : DataState<List<String>> {
        return try {
            val catPics = networkApi.getCatPictures()
            DataState.success(catPics)
        } catch(ex: Throwable) {
            DataState.failed(ex)
        }
    }


}

class NetworkApi(val data: List<String>? = null, val error: Throwable? = null) {
    /**
     * Returns a list of cat picture urls, or throws an Error
     */
    fun getCatPictures(): List<String>  {
        data?.let { return it }
        error?.let { throw it }
        return emptyList()
    }
}

sealed class DataState<T> {
    data class Success<T>(var data: T): DataState<T>()
    data class Failed<T>(var e: Throwable): DataState<T>()

    companion object{
        fun <T> success(data: T): DataState<T> = Success(data)
        fun <T> failed(e: Throwable): DataState<T> = Failed(e)
    }
}


fun testNetworkSuccess(){
    val screenLogs = Screen(Repository(NetworkApi(listOf("catPicture1.png","catPicture2.png")))).loadPage()
//    Write tests for a network success result here

    assert(screenLogs.size == 4)
}
fun testNetworkFailure() {
    val screenLogs = Screen(Repository(NetworkApi(null, Throwable("Failed to load")))).loadPage()
//    Write tests for a network failed result here
    assert(screenLogs[1] == "Failed to load")
}

// Assert method to be used for testing
fun assert(check: Boolean) {
    if (!check) {
        println("\u001B[31mAssertion failure on line: ${Thread.currentThread().getStackTrace()[2].getLineNumber()}\u001B[0m")
    }
}

fun main () {
    testNetworkSuccess()
    testNetworkFailure()
}