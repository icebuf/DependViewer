package com.github.icebuf.dependview;

import com.intellij.lang.Language;

public class GroovyLanguage extends Language {

    public static final GroovyLanguage INSTANCE = new GroovyLanguage();

    private GroovyLanguage() {
        super("Groovy");
    }
}
