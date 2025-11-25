package io.hivebit.companion.android.onboarding.welcome

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.hivebit.companion.android.R
import io.hivebit.companion.android.common.R as commonR
import io.hivebit.companion.android.onboarding.OnboardingScreen
import io.hivebit.companion.android.util.compose.HomeAssistantAppTheme

@Composable
fun WelcomeView(onContinue: () -> Unit) {
    OnboardingScreen(Modifier.verticalScroll(rememberScrollState())) {
        Image(
            painter = painterResource(id = R.drawable.hivebit_logo_gold),
            contentDescription = stringResource(
                id = commonR.string.app_name,
            ),
            modifier = Modifier
                .size(width = 380.dp, height = 162.dp)
                .padding(bottom = 48.dp),
        )
        Text(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color(0xFFFFFFFF),  // Pure White from HivebitColors.md On Accent
            text = stringResource(commonR.string.welcome_hass),
        )
        Text(
            fontSize = 19.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFFFFFFFF),  // Pure White from HivebitColors.md Text Primary Dark Mode
            text = stringResource(commonR.string.welcome_hass_desc),
            modifier = Modifier.fillMaxWidth().padding(vertical = 18.dp),
        )

        Button(
            onClick = onContinue,
        ) {
            Text(text = stringResource(id = commonR.string.continue_connect))
        }
    }
}

@Composable
@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
private fun PreviewWelcome() {
    HomeAssistantAppTheme {
        WelcomeView(onContinue = {})
    }
}
