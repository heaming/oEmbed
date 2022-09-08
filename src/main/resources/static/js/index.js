let searchBtn = $("#searchBtn");
let resultList = $("#resultList");
let questionBtn = $("#questionBtn");


// * event
searchBtn.on("click", searchBtnHandler);
questionBtn.on("click", questionBtnHandler);
$("#urlInput").on("keyup", function(e) {
    if(e.keyCode == '13') {
        searchBtnHandler();
    }
})

// * 유효성 검사
function invalidCheck(urlInputValue) {
    if(urlInputValue.includes("twitter") || urlInputValue.includes("vimeo") || urlInputValue.includes("youtube")) {
        return 200;
    }

    if(urlInputValue.includes("instagram")) {
        return 100;
    }
    return 400;
}


// * 확인
function searchBtnHandler() {
    const urlInputValue = $("#urlInput").val();
    const flag = invalidCheck(urlInputValue);

    if(flag == 200) {
        submit(urlInputValue);
    } else {
        customAlert(flag);
    }
}

// * ajax
function submit(urlInputValue) {
    $.ajax({
        url: "/rest/search",
        type: "POST",
        headers: {
            "Accept" : "application/json",
            "Content-Type" : "application/json",
        },
        data: JSON.stringify({
            "searchUrl" : urlInputValue,
        }),
        dataType: "json",
        success: function (result) {
            if(result) {
                listHandler(result["data"]);
            } else {
                console.log("fail : none result");
            }
        },
        error: function (data) {
            customAlert(404);
        }
    })
}


// * UI
//  ** instagram 관련 안내
function questionBtnHandler() {
    Swal.fire({
        icon: 'info',
        title: 'Token Required',
        html: 'oEmbed 읽기 기능에 대해 <b>승인을 받은 사용자</b>만이 <br>Instagram oEmbed 기능을 사용할 수 있습니다.',
        footer: '<a href="https://developers.facebook.com/docs/instagram/oembed/">더 자세히 알고 싶다면...</a>'
    })
}

//  ** alert
function customAlert(code) {
    if(code == 100) {
        Swal.fire(
            '준비중🛠',
            '서비스 준비 중입니다',
            'error'
        )
    }

    if(code == 400) {
        Swal.fire(
            'URL🙄',
            '입력하신 url을 다시 확인해주세요',
            'question'
        )
    }

    if(code == 404) {
        Swal.fire(
            '없어요😥',
            '요청하신 페이지를 찾을 수 없습니다',
            'question'
        )
    }
    $("#urlInput").val("");
}


//  ** list 자식 노드 구성
function listUIHandler(key, value) {

    const listUI = `
        <tr>
            <td className="px-4 border-top">
                <div className="d-flex align-items-center text-gray">
                    ${key}
                </div>
            </td>
            <td className="px-4 border-top text-end">${value}</td>
        </tr>`;

    return listUI;
}


//  ** list 구성
function listHandler(result) {
    let innerHTML = "";

    for(key in result) {
        let customValue = "";

        if(key == "thumbnail_url") {
            customValue += `<div><img src='${result[key]}' height='${result["thumbnail_height"]}' width='${result["thumbnail_width"]}'/></div>`;
        }

        if(key.includes("url")) {
            customValue += `<a href='${result[key]}'>${result[key]}<a>`;
        }  else {
            customValue += result[key];
        }

        if(key == "html") {
            customValue += `<p>${result[key].replace("<","&lt").replace(">","&gt")}</p>`;
        }

        innerHTML += listUIHandler(key, customValue);
    }

    resultList.html("");
    resultList.append(innerHTML);
    $("#urlInput").val("");
}














