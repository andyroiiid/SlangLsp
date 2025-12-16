package dev.andrewhuang.slanglsp

import org.jetbrains.plugins.textmate.api.TextMateBundleProvider

class SlangTextMateBundleProvider : TextMateBundleProvider {
    override fun getBundles(): List<TextMateBundleProvider.PluginBundle> {
        return listOf(
            TextMateBundleProvider.PluginBundle("slang", SlangTextMateBundle.path)
        )
    }
}