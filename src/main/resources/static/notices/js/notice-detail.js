var notice_detail = {
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
        window.location.href = 'http://localhost:8080/notice'
    },
    update : function () {
        var noticeSeq = document.location.href.split("http://localhost:8080/notice/");
        window.location.href = 'http://localhost:8080/notice/'+noticeSeq+'/update'
    },
    delete : function () {
    var link = document.location.href; console.log(link);
    var noticeSeq = document.location.href.split("http://localhost:8080/notice/");
        $.ajax({
            type: 'DELETE',
            url: '/api/v1/notice/' + noticeSeq,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
        }).done(function(){
            alert('글이 삭제되었습니다.');
            window.location.href = "/notice";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
};
notice_detail.init();