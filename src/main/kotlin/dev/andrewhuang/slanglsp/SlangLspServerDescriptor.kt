package dev.andrewhuang.slanglsp

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor

class SlangLspServerDescriptor(project: Project) : ProjectWideLspServerDescriptor(project, "SlangLsp") {
    private val settings = SlangLspSettings.getInstance(project)

    override fun isSupportedFile(file: VirtualFile): Boolean {
        return file.fileType is SlangFileType
    }

    override fun createCommandLine(): GeneralCommandLine {
        return GeneralCommandLine(settings.slangdPath)
    }
}
