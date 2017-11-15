/*
 *      Author :::  Brian Sterling
 *     Program ::: Bases de Datos
 *  Credential ::: SIST0008-G01:SIV
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Artista;
import util.DbUtil;

public class ArtistaDAO
{
    private Connection connection;

    public ArtistaDAO()
    {
        connection = DbUtil.getConnection();
    }

    public void addUser(Artista user)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into artista(cedula,nombre,edad,obra,estilo) values (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, user.getCedula());
            preparedStatement.setString(2, user.getNombre());
            preparedStatement.setInt(3, user.getEdad());
            preparedStatement.setString(4, user.getObra());
            preparedStatement.setString(5, user.getEstilo());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void deleteUser(int cedula)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from artista where cedula=?");
            // Parameters start with 1
            preparedStatement.setInt(1, cedula);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateUser(Artista user)
    {
        try 
        {
            PreparedStatement preparedStatement = connection.prepareStatement("update artista set cedula=?, nombre=?, edad=?, obra=?, estilo=?" + "where cedula=?");
            preparedStatement.setInt(1, user.getCedula());
            preparedStatement.setString(2, user.getNombre());
            preparedStatement.setInt(3, user.getEdad());
            preparedStatement.setString(4, user.getObra());
            preparedStatement.setString(5, user.getEstilo());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Artista> getAllUsers()
    {
        List<Artista> users = new ArrayList<Artista>();
        try
        {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from artista");
            while (rs.next())
            {
                Artista user = new Artista();
                user.setCedula(rs.getInt("cedula"));
                user.setNombre(rs.getString("firstname"));
                user.setEdad(rs.getInt("edad"));
                user.setObra(rs.getString("obra"));
                user.setEstilo(rs.getString("estilo"));
                users.add(user);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return users;
    }

    public Artista getUserById(int cedula)
    {
        Artista user = new Artista();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from artista where cedula=?");
            preparedStatement.setInt(1, cedula);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
            {
                user.setCedula(rs.getInt("cedula"));
                user.setNombre(rs.getString("firstname"));
                user.setEdad(rs.getInt("edad"));
                user.setObra(rs.getString("obra"));
                user.setEstilo(rs.getString("estilo"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return user;
    }
}