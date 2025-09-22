package com.example.chatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.chatapp.data.SampleData
import com.example.chatapp.model.Message
import com.example.chatapp.ui.theme.ChatAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatAppTheme {
                Surface(modifier = Modifier.fillMaxSize().padding(20.dp)) {
                    // Create a list of sample messages
                    val messages = SampleData.conversationSample

                    // Display conversation
                    Conversation(messages)

                    // A simple scrollable column
//                    ScrollableColumn()

                    // A non-scrollable column
//                    Column() {
//                        repeat(50) { index ->
//                            Text(text = "Item #" + (index + 1).toString())
//                            Spacer(modifier = Modifier.height(8.dp))
//                        }
//                    }
                }
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Composable
fun MessageCard(msg: Message) {
    // Add padding around our message
    Row(modifier = Modifier.padding(10.dp)) {
        Image(
            painter = painterResource(R.drawable.yoda),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
                // add border to image using Material Theme color
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        // We keep track if the message is expanded or not in this variable
        // NOTE: Composables (and their children) using this state will get redrawn automatically when the value is updated.
        var isExpanded by remember { mutableStateOf(false) }

        // We toggle the isExpanded variable when we click on this Column
        Column (modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            // Author
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )

            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(8.dp))

            // Message body
            Surface(shape = MaterialTheme.shapes.medium,
                shadowElevation = 2.dp) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),

                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun ScrollableColumn() {
    // Remember a scroll state so Compose knows where the scroll position is
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState) // makes the column scrollable!
            .padding(16.dp)
    ) {
        repeat(50) { index ->
            Text(text = "Item #" + (index+1).toString())
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
