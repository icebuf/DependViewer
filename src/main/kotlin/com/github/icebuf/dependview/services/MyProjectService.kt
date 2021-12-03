package com.github.icebuf.dependview.services

import com.intellij.openapi.project.Project
import com.github.icebuf.dependview.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
