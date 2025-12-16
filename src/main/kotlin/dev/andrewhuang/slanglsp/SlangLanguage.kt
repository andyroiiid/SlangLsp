package dev.andrewhuang.slanglsp

import com.intellij.lang.Language

object SlangLanguage : Language("Slang") {
    @Suppress("unused")
    private fun readResolve(): Any = SlangLanguage
}
