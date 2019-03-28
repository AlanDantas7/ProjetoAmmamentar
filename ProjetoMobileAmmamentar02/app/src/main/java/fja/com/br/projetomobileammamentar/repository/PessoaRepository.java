package fja.com.br.projetomobileammamentar.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import fja.com.br.projetomobileammamentar.models.Pessoa;
import fja.com.br.projetomobileammamentar.util.DAOUtil;

public class PessoaRepository {


    private DAOUtil dataBaseUtil;

    public PessoaRepository(Context context){

        this.dataBaseUtil = new DAOUtil(context);
    }


    public DAOUtil getDataBaseUtil(){ return  dataBaseUtil;}

    public void setDataBaseUtil(DAOUtil dataBaseUtil){

    this.dataBaseUtil =dataBaseUtil;
    }

    public void salvar(Pessoa pessoa){
        ContentValues cv = new ContentValues();
        cv.put("nome",pessoa.getNome());
        cv.put("cpf",pessoa.getCpf());
        cv.put("rg",pessoa.getRg());
        cv.put("telefone",pessoa.getTelefone());
        cv.put("email", pessoa.getEmail());
        cv.put("senha",pessoa.getSenha());
        cv.put("endereco",pessoa.getEndereco());
        dataBaseUtil.getConnection().insert("tb_pessoa",null,cv);

    }

    public void atualizar (Pessoa pessoa){

        ContentValues cv = new ContentValues();
        cv.put("nome",pessoa.getNome());
        cv.put("cpf",pessoa.getCpf());
        cv.put("rg",pessoa.getRg());
        cv.put("telefone",pessoa.getTelefone());
        cv.put("email", pessoa.getEmail());
        cv.put("senha",pessoa.getSenha());
        cv.put("endereco",pessoa.getEndereco());

        dataBaseUtil.getConnection().update("tb_Pessoa", cv, "idCadastroPessoa = ?", new String[]{Integer.toString(pessoa.getIdCadastroPessoa())});

    }

    public Integer excluir(int codigo) {

        return dataBaseUtil.getConnection().delete("tb_Pessoa", "idCadastroPessoa=?", new String[]{Integer.toString(codigo)});
    }

    public Pessoa getPessoa(int codigo) {

        Pessoa pessoa = new Pessoa();
        String sql = "SELECT * FROM tb_Pessoa WHERE idCadastroPessoa = " + Integer.toString(codigo);
        Cursor cursor = dataBaseUtil.getConnection().rawQuery(sql, null);
        cursor.moveToFirst();

        pessoa.setIdCadastroPessoa(cursor.getInt(cursor.getColumnIndex("idCadastroPessoa")));
        pessoa.setNome(cursor.getString(cursor.getColumnIndex("Nome")));
        pessoa.setCpf(cursor.getString(cursor.getColumnIndex("Cpf")));
        pessoa.setRg(cursor.getString(cursor.getColumnIndex("Rg")));
        pessoa.setTelefone(cursor.getString(cursor.getColumnIndex("Telefone")));
        pessoa.setEmail(cursor.getString(cursor.getColumnIndex("Email")));
        pessoa.setSenha(cursor.getString(cursor.getColumnIndex("Senha")));
        pessoa.setEndereco(cursor.getString(cursor.getColumnIndex("Endereco")));

        cursor.close();

        return pessoa;
    }


    public List<Pessoa> getTodos() {

        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM tb_Pessoa";
        Cursor cursor = dataBaseUtil.getConnection().rawQuery(sql, null);
        while (!cursor.isAfterLast()) {

            Pessoa pessoa = new Pessoa();
            pessoa.setIdCadastroPessoa(cursor.getInt(cursor.getColumnIndex("idCadastroPessoa")));
            pessoa.setNome(cursor.getString(cursor.getColumnIndex("Nome")));
            pessoa.setCpf(cursor.getString(cursor.getColumnIndex("Cpf")));
            pessoa.setRg(cursor.getString(cursor.getColumnIndex("Rg")));
            pessoa.setTelefone(cursor.getString(cursor.getColumnIndex("Telefone")));
            pessoa.setEmail(cursor.getString(cursor.getColumnIndex("Email")));
            pessoa.setSenha(cursor.getString(cursor.getColumnIndex("Senha")));
            pessoa.setEndereco(cursor.getString(cursor.getColumnIndex("Endereco")));
            pessoas.add(pessoa);
            cursor.moveToNext();
        }

        cursor.close();
        return pessoas;
    }


}


