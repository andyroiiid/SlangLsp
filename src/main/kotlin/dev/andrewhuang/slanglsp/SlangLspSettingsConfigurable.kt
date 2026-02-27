package dev.andrewhuang.slanglsp

import com.intellij.openapi.options.BoundSearchableConfigurable
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogPanel
import com.intellij.platform.lsp.api.LspServerManager
import com.intellij.ui.dsl.builder.bindText
import com.intellij.ui.dsl.builder.panel

class SlangLspSettingsConfigurable(private val project: Project) : BoundSearchableConfigurable(
    "SlangLsp",
    "SlangLsp",
) {
    private val settings = SlangLspSettings.getInstance(project)

    override fun createPanel(): DialogPanel {
        return panel {
            row {
                label("Slangd path:")
                @Suppress("UnstableApiUsage")
                textFieldWithBrowseButton(project)
                    .bindText(
                        getter = { settings.slangdPath },
                        setter = { settings.slangdPath = it }
                    )
            }
        }
    }

    override fun apply() {
        super.apply()
        val manager = LspServerManager.getInstance(project)
        manager.stopAndRestartIfNeeded(SlangLspServerSupportProvider::class.java)
    }
}