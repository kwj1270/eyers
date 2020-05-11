var freeboard_detail = {
    init : function () {
        var _this = this;
        $('#btn-list').on('click', function(){
            _this.list();
        })
        $('#btn-update').on('click', function(){
            _this.update();
        })
        $('#btn-delete').on('click', function(){
            _this.delete();
        })
    },

    list : function () {
        window.location.href = 'http://localhost:8080/freeboard'
    },
    update : function () {
        var stringArr = document.location.href.split("http://localhost:8080/freeboard/");
        var freeboardSeq = stringArr[1];
        window.location.href = 'http://localhost:8080/freeboard/'+freeboardSeq+'/update'
    },
    delete : function () {
    var link = document.location.href; console.log(link);
    var freeboardSeq = document.location.href.split("http://localhost:8080/freeboard/");
        $.ajax({
            type: 'DELETE',
            url: '/api/v1/freeboard/' + freeboardSeq,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
        }).done(function(){
            alert('글이 삭제되었습니다.');
            window.location.href = "/freeboard";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
};
freeboard_detail.init();