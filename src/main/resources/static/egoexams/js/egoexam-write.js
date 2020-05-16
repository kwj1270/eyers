var egoexam_write = {
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
        window.location.href = 'http://localhost:8080/egoexam'
    },

    save : function () {
        var _this = this;
        var today = new Date();

        var form = $('#egoexamForm')[0];
        var file = new FormData(form);
        /*
        var file =  $('#egoexamName').val();
*/
        $.ajax({
            type: 'POST',
            url: '/api/v1/file',
            enctype: 'multipart/form-data',
            contentType : false,
            processData : false,
            data: file
            }).done(function(egoexamFile){
                var data = {
                    egoexamTitle: $('#egoexamTitle').val(),
                    egoexamName: $('#egoexamName').val(),
                    egoexamContent: $('#egoexamContent').val(),
                    egoexamFile : egoexamFile,
                    egoexamDate: today.toLocaleString('ko-KR','full'),
                };
                $.ajax({
                    type: 'POST',
                    url: '/api/v1/egoexam',
                    dataType: 'json',
                    contentType: 'application/json; charset=utf-8',
                    data: JSON.stringify(data)
                    }).done(function(){
                        alert('게시글이 생성되었습니다.');
                        window.location.href = "/egoexam";
                    }).fail(function(error){
                        alert(JSON.stringify(error));
                    });
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
    }
};
egoexam_write.init();