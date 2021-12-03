package com.github.icebuf.dependview;

import com.intellij.codeInsight.daemon.LineMarkerInfo;
import com.intellij.codeInsight.daemon.LineMarkerProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class DependencyLineMarkerProvider implements LineMarkerProvider {
    @Override
    public LineMarkerInfo<?> getLineMarkerInfo(@NotNull PsiElement element) {
        Intrinsics.checkParameterIsNotNull(element, "element");
        findLibraryName(element);
//        try {
//            String libraryName = ExtensionsKt.findLibraryName(element);
//            if (libraryName == null) {
//                return null;
//            }
//            NetworkManager.INSTANCE.requestLibraryAsync(libraryName);
//            TextRange textRange = element.getTextRange();
//            Icon icon = Config.INSTANCE.getICON();
//            Function1 access$getTOOLTIP$p = Companion.getTOOLTIP();
//            Function function = (Function) (access$getTOOLTIP$p == null ? null : new MethodsCountLineMarkerProviderKt$sam$Function$ebf4d3ec(access$getTOOLTIP$p));
//            Function2 access$getCLICK$p = Companion.getCLICK();
//            return (LineMarkerInfo) new LineMarkerInfo<>(element, textRange, icon, 4, function, (GutterIconNavigationHandler) (access$getCLICK$p == null ? null : new MethodsCountLineMarkerProviderKt$sam$GutterIconNavigationHandler$3ea493b7(access$getCLICK$p)), GutterIconRenderer.Alignment.LEFT);
//        } catch (Exception e) {
//            PrintStream printStream = System.err;
//            Object[] objArr = {element.getText()};
//            String format = String.format("Could not process element: %s", Arrays.copyOf(objArr, objArr.length));
//            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(this, *args)");
//            printStream.println(format);
//            Throwable th = e;
//            if (th == null) {
//                throw new TypeCastException("null cannot be cast to non-null type java.lang.Throwable");
//            }
//            th.printStackTrace();
            return null;
//        }
    }

    public static String findLibraryName(PsiElement receiver) throws RuntimeException {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        if (receiver instanceof LeafPsiElement) {
            System.out.println(receiver.getClass() + " " + receiver);
//            return extractLibraryName(((LeafPsiElement) receiver).getText());
        }
        System.out.println(receiver);
//        if (receiver instanceof GrString) {
//            return extractLibraryName(evaluate((GrString) receiver));
//        }
        return null;
    }
//
//    public static String extractLibraryName(String receiver) {
//        MatchGroupCollection groups;
//        MatchGroup matchGroup;
//        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
//        MatchResult matchEntire = new Regex("^.*?([^:\"']+:[^:]+:[^:\"'@]+).*?$").matchEntire(receiver);
//        if (matchEntire == null || (groups = matchEntire.getGroups()) == null || (matchGroup = groups.get(1)) == null) {
//            return null;
//        }
//        return matchGroup.getValue();
//    }
//
//    public static final String evaluate(GrString receiver) throws RuntimeException {
//        String str;
//        Intrinsics.checkParameterIsNotNull(receiver, "receiver");
//        Collection<ExtModel> collectExts = collectExts(ModuleManager.getInstance(receiver.getProject()));
//        StringBuilder sb = new StringBuilder();
//        StringBuilder $receiver2 = sb;
//        Iterator<PsiElement> childIterator = childIterator((PsiElement) receiver, PsiElement.class);
//        while (childIterator.hasNext()) {
//            PsiElement it = childIterator.next();
//            if (it instanceof GrStringContent) {
//                $receiver2.append(((GrStringContent) it).getText());
//            } else if (it instanceof GrStringInjection) {
//                Collection arrayList = new ArrayList();
//                for (Object element$iv$iv : PsiTreeUtil.findChildrenOfType(it, LeafPsiElement.class)) {
//                    if (isIdentifierElement(((LeafPsiElement) element$iv$iv).getElementType())) {
//                        arrayList.add(element$iv$iv);
//                    }
//                }
//                for (LeafPsiElement identifier : (List) arrayList) {
//                    Iterator it2 = collectExts.iterator();
//                    while (true) {
//                        if (!it2.hasNext()) {
//                            str = null;
//                            break;
//                        }
//                        String r$iv = (String) ((ExtModel) it2.next()).getProperty(identifier.getText(), String.class).value();
//                        if (r$iv != null) {
//                            str = r$iv;
//                            break;
//                        }
//                        Unit unit = Unit.INSTANCE;
//                    }
//                    String str2 = str;
//                    if (str2 != null) {
//                        $receiver2.append(str2);
//                        Unit unit2 = Unit.INSTANCE;
//                    } else {
//                        Object[] objArr = {identifier.getText()};
//                        String format = String.format("Identifier not found: %s", Arrays.copyOf(objArr, objArr.length));
//                        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(this, *args)");
//                        throw new RuntimeException(format);
//                    }
//                }
//                continue;
//            } else {
//                continue;
//            }
//            Unit unit3 = Unit.INSTANCE;
//        }
//        Unit unit4 = Unit.INSTANCE;
//        String sb2 = sb.toString();
//        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply {\n…       }\n    }.toString()");
//        return sb2;
//    }



}
