document.addEventListener("DOMContentLoaded", () => {
    const nav = document.querySelector("nav");

    nav.addEventListener("click", (ev) => {
        let tagName = ev.target.tagName;

        if (tagName === "LI") {
            let menu = ev.target.textContent;

            let urlPath = `${rootPath}`;

            if (menu === "HOME") {
                urlPath += "/";
            } else if (menu === "학생 정보") {
                urlPath += "/student";
            } else if (menu === "성적일람표") {
                urlPath += "/score";
            } else if (menu === "로그인") {
                urlPath += "/login";
            }

            location.href = urlPath;

        }
    })
})