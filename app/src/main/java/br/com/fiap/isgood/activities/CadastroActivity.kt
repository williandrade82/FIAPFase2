package br.com.fiap.isgood.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.fiap.isgood.R
import com.google.android.material.snackbar.Snackbar

class CadastroActivity : AppCompatActivity() {

    lateinit var editTextTextEmail: EditText;
    lateinit var editTextNome: EditText;
    lateinit var editTextSenha: EditText;
    lateinit var editTextSenhaConfirmacao: EditText;
    lateinit var editTextCEP: EditText;
    lateinit var buttonCadastrar: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        editTextTextEmail = findViewById(R.id.editTextTextEmail);
        editTextNome = findViewById(R.id.editTextNome);
        editTextSenha = findViewById(R.id.editTextSenha);
        editTextSenhaConfirmacao = findViewById(R.id.editTextSenhaConfirmacao);
        editTextCEP = findViewById(R.id.editTextCEP);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);
    }

    open fun cadastrar(v: View) {
        if (editTextTextEmail.text.isNotEmpty() && editTextNome.text.isNotEmpty() && editTextSenha.text.isNotEmpty() && editTextSenhaConfirmacao.text.isNotEmpty() && editTextCEP.text.isNotEmpty()){
            if (!editTextSenha.text.equals(editTextSenhaConfirmacao.text)){
                Snackbar.make(
                    v,
                    "Conta criada com sucesso",
                    Snackbar.LENGTH_LONG
                ).setAction(null) {
                    val toastTrue =
                        Toast.makeText(this, "Por favor preencha email e senha", Toast.LENGTH_SHORT)
                    toastTrue.setGravity(Gravity.TOP, 0, 0)
                    toastTrue.show()
                }.show()

                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("fromCadastro",true);
                startActivity(intent)
            }else {
                showMessage("Senha e confirmação não são iguais",v);
            }
        }else {
            showMessage("Por favor preencha todos os dados",v);
        }
    }

    fun showMessage (texto:String, v: View) {
        Snackbar.make(
            v,
            texto,
            Snackbar.LENGTH_LONG
        ).setAction(null) {
            val toastTrue =
                Toast.makeText(this, texto, Toast.LENGTH_SHORT)
            toastTrue.setGravity(Gravity.TOP, 0, 0)
            toastTrue.show()
        }.show()
    }
}