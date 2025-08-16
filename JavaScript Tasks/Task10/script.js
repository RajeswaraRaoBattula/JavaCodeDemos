document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("registrationForm");
    const progressBar = document.getElementById("formProgress");
    const captchaQuestion = document.getElementById("captchaQuestion");
    const captchaAnswer = document.getElementById("captchaAnswer");
    const submitBtn = document.getElementById("submitBtn");

    let captchaResult = 0;

    function generateCaptcha() {
        let a = Math.floor(Math.random() * 10) + 1;
        let b = Math.floor(Math.random() * 10) + 1;
        captchaResult = a + b;
        captchaQuestion.textContent = `${a} + ${b} = ?`;
    }

    generateCaptcha();

    function updateProgress() {
        const inputs = form.querySelectorAll("input, select, textarea");
        let filled = 0;
        inputs.forEach(input => {
            if (input.checkValidity()) {
                filled++;
            }
        });
        let percent = Math.round((filled / inputs.length) * 100);
        progressBar.style.width = percent + "%";
        progressBar.textContent = percent + "%";
    }

    form.addEventListener("input", function () {
        updateProgress();
        if (form.checkValidity() && parseInt(captchaAnswer.value) === captchaResult) {
            submitBtn.disabled = false;
        } else {
            submitBtn.disabled = true;
        }
    });

    form.addEventListener("submit", function (e) {
        e.preventDefault();
        if (parseInt(captchaAnswer.value) !== captchaResult) {
            captchaAnswer.setCustomValidity("Incorrect captcha");
            captchaAnswer.reportValidity();
            return;
        }
        if (!form.checkValidity()) {
            e.stopPropagation();
            form.classList.add("was-validated");
            return;
        }
        const toast = new bootstrap.Toast(document.getElementById("successToast"));
        toast.show();
        form.reset();
        submitBtn.disabled = true;
        generateCaptcha();
        updateProgress();
    });
});
