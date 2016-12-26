package abbra.com.br.calculoimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText peso;
    private EditText altura;
    private Button botaoCalcular;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        peso= (EditText) findViewById(R.id.pesoId);
        altura = (EditText) findViewById(R.id.alturaId);
        botaoCalcular = (Button) findViewById(R.id.botao_calcularId);
        resultado = (TextView) findViewById(R.id.resultadoId);

        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //recuperar o texto digitado
                String pesoDigitado = peso.getText().toString();
                String alturaDigitado = altura.getText().toString();


                if((pesoDigitado.isEmpty())||(alturaDigitado.isEmpty())){
                    resultado.setText("Nenhum valor foi informado");
                } else{
                    double altura = Double.parseDouble(alturaDigitado);
                    double peso = Double.parseDouble(pesoDigitado);
                    double pesoquadrado = (altura*altura);
                    double imc = peso/pesoquadrado;

                    resultado.setText("O resultado é "+imc);

                    if(imc < 17){
                        resultado.setText("Seu IMC ficou em.................:"+String.format( "%.2f", imc) + "\n" + "Você está : Muito Abaixo do Peso");

                    }else  if((imc > 17)&& (imc<18.49)){
                        resultado.setText("Seu IMC ficou em.................:"+String.format( "%.2f", imc) + "\n" + "Você está : Abaixo do Peso");

                    }else  if((imc > 18.5)&& (imc<24.99)){
                        resultado.setText("Seu IMC ficou em.................:"+String.format( "%.2f", imc) + "\n" + "Você está com: Peso Normal");

                    }else  if((imc > 25)&& (imc<29.99)){
                        resultado.setText("Seu IMC ficou em.................:"+String.format( "%.2f", imc) + "\n" + "Você está: Acima do Peso");

                    }else  if((imc > 30)&& (imc<34.99)){
                        resultado.setText("Seu IMC ficou em.................:"+String.format( "%.2f", imc) + "\n" + "Você está com: Obesidade I");

                    }else  if((imc > 35)&& (imc<39.99)){
                        resultado.setText("Seu IMC ficou em.................:"+String.format( "%.2f", imc) + "\n" + "Você está com: Obesidade II (severa)");

                    }else  if(imc > 40){
                        resultado.setText("Seu IMC ficou em.................:"+String.format( "%.2f", imc) + "\n" + "Você está com: Obesidade III (mórbida)");
                    }

                }

            }
        });


    }
}
