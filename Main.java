import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int number_of_employes = Integer.parseInt( input );
        employers[] all_employers = new employers[number_of_employes];
        for ( int i = 0 ; i<number_of_employes ; i++)
        {
            input = s.nextLine();
            int Superior_index = Integer.parseInt( input );

            employers employe = new employers();
            employe.superior_index = Superior_index;
            employe.HasTabel = false;
            employe.my_index = i;
            all_employers[i] = employe;
        }

        int number_of_tables = 0;
        boolean allHasTable = false;
        while ( allHasTable == false )
        {
            allHasTable = true;
            employers[] Table = new employers[number_of_employes];
            int People_in_table = 0;
            number_of_tables = number_of_tables + 1;
            for ( int i = 0 ; i<number_of_employes ; i++)
            {
                employers first_person = all_employers[i];
                if ( !first_person.get_hasTable())
                {

                    Table[People_in_table] = first_person;
                    first_person.HasTabel = true;
                    System.out.print("Table: " + first_person.getMy_index());

                    int employ_index  = i;
                    People_in_table++;

                    for ( int j = 0 ; j<number_of_employes ; j++)
                    {
                        employers new_employe = all_employers[j];
                        if ( new_employe.getMy_index() != first_person.getMy_index() ) {
                            boolean can_sit = true;
                            for (int p = 0; p < People_in_table; p++) {
                                int actual_superior_index = Table[p].getMy_index();
                                if (new_employe.getMy_index() != actual_superior_index && !new_employe.get_hasTable() && (new_employe.getsuperiorindex() == -1 || (new_employe.getsuperiorindex() != actual_superior_index && all_employers[new_employe.getsuperiorindex()].getsuperiorindex() != actual_superior_index))) {
                                    //                                System.out.println( new_employe.getMy_index() +" " + actual_superior_index +" " +  new_employe.get_hasTable() +" " + new_employe.getsuperiorindex() );
                                    continue;
                                } else {
                                    //                                System.out.println( new_employe.getMy_index() +" " + actual_superior_index +" " +  new_employe.get_hasTable() +" " + new_employe.getsuperiorindex() );

                                    can_sit = false;
                                    break;
                                }

                            }
                            if (can_sit == true) {
                                new_employe.HasTabel = true;
                                Table[People_in_table] = new_employe;
                                People_in_table++;
                                System.out.print(" " + new_employe.getMy_index());
                            } else allHasTable = false;
                        }
                    }
                    break;
                }
            }
        }
        System.out.println("Number of tables is equal: " + number_of_tables);

    }
}



class employers
{
    int superior_index;
    int my_index;
    boolean HasTabel;

    int getsuperiorindex() { return superior_index; }
    int getMy_index() { return my_index; }
    boolean get_hasTable() { return HasTabel; }

}