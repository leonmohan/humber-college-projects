public class DatabaseFactory
{
    public Database getDbObject(String dbType)
    {
        Database databaseObject = null;

        if(dbType.equals("PostgresSQL"))
        {
            databaseObject = new PostgresSQL();
        }
        else if (dbType.equals("MySQL"))
        {
            databaseObject = new MySQL();
        }
        else if (dbType.equals("OracleSQL"))
        {
            databaseObject = new OracleSQL();
        }
        else
        {
            throw new java.lang.Error("Database not supported.\nPlease enter: PostgresSQL, MySQL or OracleSQL");
        }

        return databaseObject;
    }
}
