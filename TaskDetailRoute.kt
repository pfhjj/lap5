package sa.edu.iau.cshj.studyplanner

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun TaskDetailRoute(
    title: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    TaskDetailScreen(
        uiState = TaskDetailUiState(
            title = title
        ),
        onShareClick = {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Today I’m studying: $title"
                )
            }

            context.startActivity(
                Intent.createChooser(
                    intent,
                    "Share task"
                )
            )
        },
        onBackClick = onBackClick,
        modifier = modifier
    )
}