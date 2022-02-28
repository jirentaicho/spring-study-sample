package com.volkruss

import org.apache.commons.lang3.StringUtils
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

import java.nio.file.Path
import java.nio.file.Paths

class GenerateTask extends DefaultTask {
    @TaskAction
    def codegen(){

        // 利用例
        // gradle codegen -Ptarget=dto -PsubSystem=expenses -Pfunc=salary

        println("----start-----")

        // 必須項目チェック / subSystem
        if (!project.hasProperty("subSystem")) {
            println("subSystem must not be null")
            return
        }
        // 必須項目チェック / func
        if (!project.hasProperty("func")) {
            println("func must not be null")
            return
        }

        // 今回はdtoのみだが、今後作るものによっては判別できる
        def target = null
        if(project.hasProperty("target")) {
            target = project.target;
        }

        //　エクステンションの取得
        def ext = project.extensions.findByType(CodeGenPluginExtension)
        // 利用変数定義
        def subSystem = StringUtils.lowerCase(project.subSystem.toString())
        def func = StringUtils.capitalize(project.func.toString())
        def lowerFunc = StringUtils.lowerCase(func)
        // Thymeleafに渡す変数を格納したMap
        def objects = extensionsToMap()
        // 機能名
        objects.put("subSystem", subSystem)
        // クラス名
        objects.put("upperFuncName", func)
        // テーブル及び、カラムのプレフィックス名
        objects.put("lowerFuncName", lowerFunc)

        //　出力先のフォルダパス
        def domainTarget = "${ext.domainProjectName}/${ext.srcDirName}/${ext.domainBaseName}"

        // 今回はdtoを受けたらない場合は作成しない
        // if (target == null || target.equals("dto")) {
        if (target.equals("dto")) {
            // テキストファイル
            // dtoファイルの出力パス
            // Mapオブジェクト
            generate("templates/src/Dto.txt", getTargetPath(domainTarget, "/${ext.dtoPackageName}/${subSystem}/${func}", ".java"), objects)
        }

    }

    // 出力先のディレクトリ（エクステンション）
    // ファイル名（引数）
    // 拡張子（固定値）

    // 完全なパスを返します。
    // パスの想定 domain/dto/{sales}
    Path getTargetPath(String _target, String _fileName, String suffix) {
        def target = StringUtils.replace(_target, ".", "/")
        def sb = new StringBuilder().append(target)
        def fileName = StringUtils.replace(_fileName, ".", "/")
        return Paths.get(sb.toString(), "${fileName}${suffix}")
    }

    //　Thymeleafにて取得したStringの内容を、設定したパスにUTF-8で書き込む
    void generate(String template, Path path, Map<String, Object> objects) {
        def body = processTemplate(template, objects)
        def f = path.toFile()
        f.parentFile.mkdirs()
        f.createNewFile()
        f.write(body, "UTF-8")
    }

    String processTemplate(String template, Map<String, Object> objects) {
        def resolver = new ClassLoaderTemplateResolver()
        resolver.setTemplateMode("TEXT")
        resolver.setCharacterEncoding("UTF-8")

        def templateEngine = new TemplateEngine()
        templateEngine.setTemplateResolver(resolver)

        def context = new Context()
        // 引数で受取った値を元に設定したMapから変数を設定する
        if (objects != null && !objects.isEmpty()) {
            objects.each { key, value ->
                context.setVariable(key, value)
            }
        }
        // 指定したテンプレート（テキストデータ）に対してcontextの内容を埋め込んでStringを返す（Modelのような感じ）
        return templateEngine.process(template, context)
    }

    Map<String, Object> extensionsToMap() {

        def ext = project.extensions.findByType(CodeGenPluginExtension)

        Map<String, Object> objects = new HashMap<>()
        objects.put("commonDtoPackageName", ext.commonDtoPackageName)
        objects.put("dtoPackageName", ext.dtoPackageName)
        objects.put("daoPackageName", ext.daoPackageName)
        objects.put("repositoryPackageName", ext.repositoryPackageName)
        objects.put("servicePackageName", ext.servicePackageName)
        objects.put("commonServicePackageName", ext.commonServicePackageName)
        objects.put("exceptionPackageName", ext.exceptionPackageName)
        objects.put("webBasePackageName", ext.webBasePackageName)
        objects.put("baseControllerPackageName", ext.baseControllerPackageName)
        objects.put("controllerPackageName", ext.controllerPackageName)
        objects.put("baseValidatorPackageName", ext.baseValidatorPackageName)
        objects.put("domainBaseName", ext.domainBaseName)

        return objects
    }
}