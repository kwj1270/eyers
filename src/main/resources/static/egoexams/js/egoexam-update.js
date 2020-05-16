var egoexam_update = {
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
        window.location.href = 'http://localhost:8080/egoexam'
    },
    update : function () {
        var fileSeq = $('#previousSeq').val();
        alert(fileSeq); // 여기가 우선 에러
        $.ajax({
            type: 'DELETE',
            url: '/api/v1/file/'+fileSeq,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
        }).done(function(){
            var stringArr = document.location.href.split("http://localhost:8080/egexam/");
            var stringArr2 = stringArr[1].split("/");
            var egexamSeq = stringArr2[0];
            var today = new Date();
            var form = $('#egoexamForm')[0];
            var file = new FormData(form);
            var data = {
                egoexamTitle: $('#egoexamTitle').val(),
                egoexamContent: $('#egoexamContent').val(),
                egoexamFile : egoexamFile,
                egoexamDate: today.toLocaleString('ko-KR','full'),
            };
            $.ajax({
                type: 'PUT',
                url: '/api/v1/egoexam/'+egoexamSeq,
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
                }).done(function(){
                    alert('게시글이 수되었습니다.');
                    window.location.href = "/egoexam";
                }).fail(function(error){
                    alert(JSON.stringify(error));
                });

        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var link = document.location.href;
        var stringArr = document.location.href.split("http://localhost:8080/egoexam/");
        var stringArr2 = stringArr[1].split("/");
        var egoexamSeq = stringArr2[0];
        $.ajax({
            type: 'DELETE',
            url: '/api/v1/egoexam/' + egoexamSeq,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
        }).done(function(){
            alert('글이 삭제되었습니다.');
            window.location.href = "/egoexam";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
};
egoexam_update.init();