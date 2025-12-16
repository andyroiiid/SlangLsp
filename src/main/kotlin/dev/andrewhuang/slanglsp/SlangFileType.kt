package dev.andrewhuang.slanglsp

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class SlangFileType : LanguageFileType(SlangLanguage) {
    override fun getName(): String {
        return "Slang Shader"
    }

    override fun getDescription(): String {
        return "Slang shader"
    }

    override fun getDefaultExtension(): String {
        return "slang"
    }

    override fun getIcon(): Icon {
        return SlangLanguage.icon
    }
}
