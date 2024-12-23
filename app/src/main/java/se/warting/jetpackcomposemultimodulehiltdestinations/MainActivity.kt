package se.warting.jetpackcomposemultimodulehiltdestinations

import MyNavHost
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import dagger.hilt.android.AndroidEntryPoint
import se.warting.jetpackcomposemultimodulehiltdestinations.ui.theme.JetpackComposeMultiModuleHiltDestinationsTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    @Inject
    lateinit var analytics: AnalyticsService

    private val exampleViewModel: ExampleViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        analytics.logEvent("works!!!!")


        enableEdgeToEdge()
        setContent {
            JetpackComposeMultiModuleHiltDestinationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        MyNavHost(exampleViewModel.destinations)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeMultiModuleHiltDestinationsTheme {
        Greeting("Android")
    }
}