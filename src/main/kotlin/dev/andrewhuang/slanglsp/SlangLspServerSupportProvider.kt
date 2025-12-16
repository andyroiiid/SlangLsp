package dev.andrewhuang.slanglsp

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServerSupportProvider

class SlangLspServerSupportProvider : LspServerSupportProvider {
    override fun fileOpened(
        project: Project,
        file: VirtualFile,
        serverStarter: LspServerSupportProvider.LspServerStarter
    ) {
        if (file.fileType is SlangFileType) {
            serverStarter.ensureServerStarted(SlangLspServerDescriptor(project))
        }
    }
}
