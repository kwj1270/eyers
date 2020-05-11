var notice_save = {
    init : function(){
        var _this = this;
        $('#btn-list').on('click', function(){
            _this.list();
        })
        $('#btn-save').on('click', function(){
            _this.save();
        })
    },

    save : function(){
    var data = {
            noticeTitle: $('#noticeTitle').val(),
            noticeName: $('#noticeName').val(),
            noticeContent: $('#noticeContent').val(),
            noticeDate: $('#noticeDate').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/notice',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
            }).done(function(){
                alert('공지 사항이 생성되었습니다.');
                window.location.href = "/notice";
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
    }
}
notice_save.init();