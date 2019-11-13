package com.example.spdx2xls.config

import org.jline.terminal.Terminal
import org.jline.utils.AttributedStringBuilder
import org.jline.utils.AttributedStyle
import org.springframework.beans.factory.annotation.Value

class ShellHelper {


    @Value("\${shell.out.info}")
    lateinit var infoColor: String

    @Value("\${shell.out.success}")
    lateinit var successColor: String

    @Value("\${shell.out.warning}")
    lateinit var warningColor: String

    @Value("\${shell.out.error}")
    lateinit var errorColor: String

    lateinit var terminal: Terminal

    fun ShellHelper(terminal: Terminal) {
        this.terminal = terminal
    }

    fun getColored(message: String, color: PromptColor): String {
        return AttributedStringBuilder().append(message, AttributedStyle.DEFAULT.foreground(color.toJlineAttributedStyle())).toAnsi()
    }

    fun getInfoMessage(message: String): String {
        return getColored(message, PromptColor.valueOf(infoColor))
    }

    fun getSuccessMessage(message: String): String {
        return getColored(message, PromptColor.valueOf(successColor))
    }

    fun getWarningMessage(message: String): String {
        return getColored(message, PromptColor.valueOf(warningColor))
    }

    fun getErrorMessage(message: String): String {
        return getColored(message, PromptColor.valueOf(errorColor))
    }
}

enum class PromptColor(private val value: Int) {
    BLACK(0),
    RED(1),
    GREEN(2),
    YELLOW(3),
    BLUE(4),
    MAGENTA(5),
    CYAN(6),
    WHITE(7),
    BRIGHT(8);

    fun toJlineAttributedStyle(): Int {
        return this.value
    }
}