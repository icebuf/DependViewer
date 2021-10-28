package com.github.icebuf.dependencymanager.services

import com.intellij.openapi.project.Project
import com.github.icebuf.dependencymanager.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
