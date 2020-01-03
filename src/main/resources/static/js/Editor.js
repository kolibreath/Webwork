function generate() {
    var idoc = document.getElementById('target').contentWindow.document;

    idoc.open();
    //var input = document.getElementById('input');
    //idoc.write(input.value);
    idoc.write(editor.getValue());
    idoc.close();
}

function init() {
    console.log(`function init`)
    /*var input = document.getElementById('input');

    input.addEventListener('keyup',()=>{
        //console.log('src changed');
        generate();
    });*/

    window.editor = ace.edit("input");
    editor.setTheme("ace/theme/monokai");
    editor.getSession().setMode("ace/mode/html");
    editor.setValue(`<!DOCTYPE html>
<html>
<head>
</head>

<body>
</body>

</html>`, 1);

    editor.getSession().on('change', function () {
        generate();
    });

    editor.focus();


    editor.setOptions({
        fontSize: "16pt",
        showLineNumbers: false,
        showGutter: false,
        vScrollBarAlwaysVisible: true,
        enableBasicAutocompletion: false, enableLiveAutocompletion: false
    });

    editor.setShowPrintMargin(false);
    editor.setBehavioursEnabled(false);


}