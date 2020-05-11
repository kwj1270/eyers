var notice_update = {
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
        var stringArr = document.location.href.split("http://localhost:8080/notice/");
        var stringArr2 = stringArr[1].split("/");
        var noticeSeq = stringArr2[0];
        var data = {
            noticeTitle: $('#noticeTitle').val(),
            noticeContent: $('#noticeContent').val(),
            noticeDate: $('#noticeDate').val()
        };

        $.ajax({
            type: 'PUT',
            url: '/api/v1/notice/' + noticeSeq,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
            }).done(function(){
                alert('글이 수정되었습니다.');
                window.location.href = "/notice";
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
    },
    delete : function () {
        var link = document.location.href;
        var stringArr = document.location.href.split("http://localhost:8080/notice/");
        var stringArr2 = stringArr[1].split("/");
        var noticeSeq = stringArr2[0];
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
notice_update.init();