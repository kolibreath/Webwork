function generate() {
    var idoc = document.getElementById('target').contentWindow.document;

    idoc.open();
    idoc.write(editor.getValue());
    idoc.close();
}

function newPost(call){
    let resultCode ;
    //time
    let time= Date.parse( new Date());
    let postContent = editor.getValue();
    console.log(postContent);
    let postTitle = "新文章";
    let post = {
        time:time,
        postContent:postContent,
        postTitle:postTitle,
    };

    let createNewPost = $.ajax(({
        type:"POST",
        url:"/post/new_post",
        contentType:"application/json",
        data:JSON.stringify(post),
        success:function (result) {
            resultCode = result;
        },
        error:function () {
            //todo 错误处理
        }
    }));

    $.when(createNewPost).done(()=>call(resultCode))

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