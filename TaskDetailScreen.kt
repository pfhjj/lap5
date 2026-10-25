package sa.edu.iau.cshj.studyplanner

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class TaskDetailUiState(
    val title: String
)

@Composable
fun TaskDetailScreen(
    uiState: TaskDetailUiState,
    onShareClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Task Detail",
            style = MaterialTheme.typography.headlineMedium
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = uiState.title,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }

        Button(
            onClick = onShareClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Share")
        }

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}

@Preview(
    name = "Lab Task",
    showBackground = true
)
@Composable
private fun LabTaskPreview() {
    TaskDetailScreen(
        uiState = TaskDetailUiState(
            title = "Complete Lab 5 report"
        ),
        onShareClick = {},
        onBackClick = {}
    )
}

@Preview(
    name = "Study Task",
    showBackground = true
)
@Composable
private fun StudyTaskPreview() {
    TaskDetailScreen(
        uiState = TaskDetailUiState(
            title = "Study Kotlin"
        ),
        onShareClick = {},
        onBackClick = {}
    )
}