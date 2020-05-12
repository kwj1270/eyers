var freeboard_write = {
    init : function () {
        var _this = this;
        $('#btn-list').on('click', function(){
            _this.list();
        })
        $('#btn-save').on('click', function(){
            _this.save();
        })
    },
    list : function(){
        window.location.href = 'http://localhost:8080/freeboard'
    },

    save : function () {
        var _this = this;
        var today = new Date();
        var data = {
            freeboardTitle: $('#freeboardTitle').val(),
            freeboardName: $('#freeboardName').val(),
            freeboardContent: $('#freeboardContent').val(),
            freeboardDate: today.toLocaleString('ko-KR','full'),
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/freeboard',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
            }).done(function(){
                alert('게시글이 생성되었습니다.');
                window.location.href = "/freeboard";
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
    }
};
freeboard_write.init();