package dev.andrewhuang.slanglsp

import com.intellij.openapi.components.*
import com.intellij.openapi.project.Project

@Service(Service.Level.PROJECT)
@State(name = "SlangLspSettings", storages = [Storage("slanglsp.xml")])
class SlangLspSettings : SimplePersistentStateComponent<SlangLspSettings.State>(State()) {
    companion object {
        @JvmStatic
        fun getInstance(project: Project): SlangLspSettings = project.service()
    }

    class State : BaseState() {
        var slangdPath by string("slangd")
    }

    var slangdPath
        get() = state.slangdPath ?: "slangd"
        set(value) {
            state.slangdPath = value
        }

    override fun noStateLoaded() {
        super.noStateLoaded()
        loadState(State())
    }
}