package br.com.fiap.isgood.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.TextView
import br.com.fiap.isgood.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val loginCriarContaTextView = findViewById<TextView>(R.id.textViewLoginCriarConta);
        val underlineString = SpannableString(loginCriarContaTextView.text);
        underlineString.setSpan(UnderlineSpan(),0,underlineString.length,0);
        loginCriarContaTextView.text = underlineString;
    }
}