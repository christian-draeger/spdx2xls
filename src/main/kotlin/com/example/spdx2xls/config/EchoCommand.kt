package com.example.spdx2xls.config

import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption

@ShellComponent
class EchoCommand {

    @ShellMethod("Displays greeting message to the user whose name is supplied")
    fun echo(@ShellOption("-N", "–name") name: String) =
        String.format("Hello %s! You are running spring shell cli-demo.", name)

}
