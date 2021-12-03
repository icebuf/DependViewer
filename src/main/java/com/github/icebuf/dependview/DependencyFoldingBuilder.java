package com.github.icebuf.dependview;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.FoldingModel;
import com.intellij.openapi.editor.ex.FoldingModelEx;
import com.intellij.psi.PsiElement;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DependencyFoldingBuilder extends FoldingBuilderEx {

    @Override
    public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        FoldingModelEx foldingModel;
        List<FoldingDescriptor> descriptors = new ArrayList<>();
        Editor[] editors = EditorFactory.getInstance().getEditors(document);
        Editor editor = ArraysKt.firstOrNull(editors);
        FoldingModel foldingModel2 = editor != null ? editor.getFoldingModel() : null;
        if (foldingModel2 instanceof FoldingBuilderEx) {
            foldingModel = (FoldingModelEx) foldingModel2;
        } else {
            foldingModel = null;
        }
        FoldingModelEx foldingModel3 = foldingModel;
        if (foldingModel3 == null) {
            return new FoldingDescriptor[0];
        }
        try {
            buildFoldRegionsWithGradleBuildModel(root, foldingModel3, descriptors);
        } catch (NoClassDefFoundError e) {
            for (PsiElement element : ExtensionsKt.findPossibleLibraryElements(root)) {
                try {
                    String findLibraryName = ExtensionsKt.findLibraryName(element);
                    if (findLibraryName != null) {
                        String libraryName = findLibraryName;
                        addProcessingDescriptor(element, libraryName, descriptors);
//                        NetworkManager.INSTANCE.requestLibraryAsync(libraryName);
//                        NetworkManager.INSTANCE.getLibraryStatsAsync(libraryName,
//                                new MethodsCountFoldingBuilder$buildFoldRegions$$inlined$forEach$lambda$1(element, this, descriptors, foldingModel3));
                    }
                } catch (Exception e2) {
                    PrintStream printStream = System.err;
                    Object[] objArr = {element.getText()};
                    String format = String.format("Could not process element: %s", Arrays.copyOf(objArr, objArr.length));
                    Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(this, *args)");
                    printStream.println(format);
                    e2.printStackTrace();
                }
            }
        }
        FoldingDescriptor[] foldingDescriptorArr = (FoldingDescriptor[]) descriptors.toArray(new Object[0]);
        Intrinsics.checkExpressionValueIsNotNull(foldingDescriptorArr, "descriptors.toArray<Fold…iptor>(descriptors.size))");
        return foldingDescriptorArr;
    }

    private void buildFoldRegionsWithGradleBuildModel(PsiElement root, FoldingModelEx foldingModel,
                                                      Collection<FoldingDescriptor> descriptors) throws NoClassDefFoundError {
        GradleUtils.INSTANCE.reset();
        for (PsiElement element : ExtensionsKt.findPossibleLibraryElements(root)) {
            try {
                String findLibraryName = ExtensionsKt.findLibraryName(element);
                if (findLibraryName != null) {
                    String libraryName = findLibraryName;
                    addProcessingDescriptor(element, libraryName, descriptors);
//                    NetworkManager.INSTANCE.requestLibraryAsync(libraryName);
//                    NetworkManager.INSTANCE.getLibraryStatsAsync(libraryName,
//                            new MethodsCountFoldingBuilder$buildFoldRegionsWithGradleBuildModel$$inlined$forEach$lambda$1(element, this, descriptors, foldingModel));
                }
            } catch (Exception e) {
                PrintStream printStream = System.err;
                Object[] objArr = {element.getText()};
                String format = String.format("Could not process element: %s", Arrays.copyOf(objArr, objArr.length));
                Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(this, *args)");
                printStream.println(format);
                e.printStackTrace();
            }
        }
        GradleUtils.INSTANCE.reset();
    }

    private void addProcessingDescriptor(PsiElement element, String libraryName, Collection<FoldingDescriptor> descriptors) {
//        descriptors.add(new MethodsCountFoldingBuilder$addProcessingDescriptor$1(libraryName, element.getNode(), element.getTextRange()));
        descriptors.add(new FoldingDescriptor(element.getNode(), element.getTextRange()) {
            @Override
            public @Nullable String getPlaceholderText() {
                Object[] objArr = {libraryName};
                String format = String.format("%s [processing...]", Arrays.copyOf(objArr, objArr.length));
                Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(this, *args)");
                return format;
            }
        });
    }


    /**
     * Gets the Simple Language 'value' string corresponding to the 'key'
     *
     * @param node Node corresponding to PsiLiteralExpression containing a string in the format
     *             SIMPLE_PREFIX_STR + SIMPLE_SEPARATOR_STR + Key, where Key is
     *             defined by the Simple org.intellij.sdk.language file.
     */
    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        return null;
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return true;
    }

}
