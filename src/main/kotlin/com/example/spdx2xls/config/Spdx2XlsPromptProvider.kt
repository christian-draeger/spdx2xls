package com.example.spdx2xls.config

import org.jline.utils.AttributedString
import org.jline.utils.AttributedStyle
import org.springframework.shell.jline.PromptProvider
import org.springframework.stereotype.Component

@Component
class Spdx2XlsPromptProvider : PromptProvider {
    override fun getPrompt(): AttributedString =
            AttributedString(
                    "SPDX 2 XLS:>",
                    AttributedStyle.DEFAULT.foreground(AttributedStyle.BLUE)
            )
}
