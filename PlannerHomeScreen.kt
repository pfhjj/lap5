package sa.edu.iau.cshj.studyplanner

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class PlannerUiState(
    val greeting: String = "Welcome, Fajr!",
    val totalTasks: Int = 3,
    val completedTasks: Int = 0,
    val tasks: List<String> = listOf(
        "Study Kotlin",
        "Complete Lab 5 report",
        "Review Mobile Programming"
    )
)

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onCompleteTask: () -> Unit,
    onTaskClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val progress =
        if (uiState.totalTasks > 0) {
            uiState.completedTasks.toFloat() / uiState.totalTasks
        } else {
            0f
        }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = uiState.greeting,
            style = MaterialTheme.typography.headlineMedium
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Study Progress",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "${uiState.completedTasks} of ${uiState.totalTasks} done"
                )

                Spacer(modifier = Modifier.height(12.dp))

                LinearProgressIndicator(
                    progress = {
                        progress
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Text(
            text = "My Tasks",
            style = MaterialTheme.typography.titleLarge
        )

        uiState.tasks.forEach { task ->
            Button(
                onClick = {
                    onTaskClick(task)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(task)
            }
        }

        Button(
            onClick = onCompleteTask,
            enabled = uiState.completedTasks < uiState.totalTasks,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Complete One Task")
        }
    }
}

@Composable
fun PlannerHomeRoute(
    onTaskClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var uiState by remember {
        mutableStateOf(
            PlannerUiState()
        )
    }

    PlannerHomeScreen(
        uiState = uiState,
        onCompleteTask = {
            if (uiState.completedTasks < uiState.totalTasks) {
                uiState = uiState.copy(
                    completedTasks = uiState.completedTasks + 1
                )
            }
        },
        onTaskClick = onTaskClick,
        modifier = modifier
    )
}

@Preview(
    name = "Nothing Done",
    showBackground = true
)
@Composable
private fun NothingDonePreview() {
    PlannerHomeScreen(
        uiState = PlannerUiState(
            completedTasks = 0
        ),
        onCompleteTask = {},
        onTaskClick = {}
    )
}

@Preview(
    name = "Everything Done",
    showBackground = true
)
@Composable
private fun EverythingDonePreview() {
    PlannerHomeScreen(
        uiState = PlannerUiState(
            completedTasks = 3
        ),
        onCompleteTask = {},
        onTaskClick = {}
    )
}