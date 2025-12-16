package dev.andrewhuang.slanglsp

import java.nio.file.Files
import java.nio.file.Path

object SlangTextMateBundle {
    val path: Path by lazy {
        val bundleDir = Files.createTempDirectory("slang-lsp");

        val infoPlist = javaClass.getResourceAsStream("/slang.tmBundle/info.plist")
        if (infoPlist != null) {
            Files.copy(infoPlist, bundleDir.resolve("info.plist"))
        }

        val tmLanguage = javaClass.getResourceAsStream("/slang.tmBundle/syntaxes/slang.tmLanguage.json")
        if (tmLanguage != null) {
            val syntaxesDir = Files.createDirectory(bundleDir.resolve("syntaxes"))
            Files.copy(tmLanguage, syntaxesDir.resolve("slang.tmLanguage.json"))
        }

        bundleDir
    }
}