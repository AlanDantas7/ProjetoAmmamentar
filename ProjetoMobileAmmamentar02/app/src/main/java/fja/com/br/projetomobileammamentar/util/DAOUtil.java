package fja.com.br.projetomobileammamentar.util;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAOUtil extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "Sistema.db";
    private static final int VERSAO = 1;

    public DAOUtil(Context context) {

        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        StringBuilder sqlDDl = new StringBuilder();
        sqlDDl.append("CREATE TABLE     tb_Pessoa ( ");
        sqlDDl.append("idCadastroPessoa         INTEGER PRIMARY KEY AUTO_INCREMENT, ");
        sqlDDl.append("nome           TEXT NOT NULL, ");
        sqlDDl.append("cpf      TEXT NOT NULL, ");
        sqlDDl.append("rg          TEXT NOT NULL, ");
        sqlDDl.append("telefone     TEXT NOT NULL, ");
        sqlDDl.append("email    TEXT NOT NULL, ");
        sqlDDl.append("senha    TEXT NOT NULL, ");
        sqlDDl.append("endereco          TEXT NOT NULL)");
        sqLiteDatabase.execSQL(sqlDDl.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_Pessoa");
        onCreate(sqLiteDatabase);
    }

    public SQLiteDatabase getConnection() {

        return this.getWritableDatabase();
    }
}

