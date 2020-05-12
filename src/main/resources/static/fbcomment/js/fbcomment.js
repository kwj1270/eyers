var fbcomment = {
    init : function () {
    var _this = this;
        $('#btn-save').on('click', function(){
            _this.save();
        })
        /*
        $('#btn-updateForm').on('click', function(){
            _this.updateForm();
        })
        $('#btn-update').on('click', function(){
            _this.update();
        })
        */
    },
    commentList: function(){
    var fbcommentFreeboard = $('#fbcommentFreeboard').val();
        $.ajax({
            url: '/api/v1/fbcomment/'+fbcommentFreeboard,
            type : 'get',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            }).done(function(data){
                var a ='';
                $.each(data, function(key, value){
                    a += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
                    a += '<div class="commentInfo'+value.fbcommentSeq+'">'+'댓글 번호 : '+value.fbcommentSeq+' / 작성자 : '+value.fbcommentName;
                    a += '<button class="btn btn-default" id="btn-updateForm" type="button" onclick="fbcomment.updateForm('+value.fbcommentSeq+', '+value.fbcommentName+' ,\''+value.fbcommentContent+'\');"> 수정 </button>';
                    a += '<button class="btn btn-default" id="btn-delete" type="button" onclick="fbcomment.delete('+value.fbcommentSeq+',\''+value.fbcommentName+'\');"> 삭제 </button>';
                    a += '<div class="commentContent'+value.fbcommentSeq+'"> <p> 내용 : '+value.fbcommentContent +'</p>';
                    a += '</div></div></div>';
                });
                $(".commentList").html(a);
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
    },
    updateForm : function(fbcommentSeq, fbcommentName, fbcommentContent){
        var _this = this;
        $('#btn-updateForm').text("취소");
        $('#btn-updateForm').on('click', function(){
            _this.commentList();
        })
        var a ='';
        a += '<div class="input-group">';
        a += '<input type="hidden" class="form-control" id="update_fbcommentSeq" value="'+fbcommentSeq+'"/>';
        a += '<input type="hidden" class="form-control" id="update_fbcommentName" value="'+fbcommentName+'"/>';
        a += '<input type="text" class="form-control" id="update_fbcommentContent" value="'+fbcommentContent+'"/>';
        a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="fbcomment.update('+fbcommentSeq+');">수정</button></span>';
        a += '</div>';
        $('.commentContent'+fbcommentSeq).html(a);
    },
    save: function(){
        var _this = this;
        var data = {
            fbcommentFreeboard: $('#fbcommentFreeboard').val(),
            fbcommentName: $('#fbcommentName').val(),
            fbcommentContent: $('#fbcommentContent').val()
        };

        $.ajax({
            url: '/api/v1/fbcomment',
            type : 'post',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
            }).done(function(){
                $('#fbcommentContent').val("")
                _this.commentList();
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
    },

    update: function(fbcommentSeq){
        var _this = this;
        var data = {
            fbcommentContent : $('#update_fbcommentContent').val()
        };
        $.ajax({
            url: '/api/v1/fbcomment/' + fbcommentSeq,
            type : 'PUT',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
            }).done(function(){
                _this.commentList();
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
    },
    delete : function(fbcommentSeq){
        var _this = this;

        if(confirm("정말로 삭제하시겠습니까?")){
        $.ajax({
            url: '/api/v1/fbcomment/' + fbcommentSeq,
            type : 'DELETE',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            }).done(function(){
                _this.commentList();
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
        } else {
            _this.commentList();}
        }
}
fbcomment.init();
fbcomment.commentList(); //페이지 로딩시 댓글 목록 출력

