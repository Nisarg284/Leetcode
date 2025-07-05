class Solution {

    public static void helper(int k,StringBuilder sb)
    {
        if(sb.length() > k)
        {
            return;
        }

        int size = sb.length();
        for(int i = 0;i<size;i++)
        {
            char curr = sb.charAt(i);
            char next = (char)(curr+1);

            if(curr == 'z')
            {
                next = 'a';
            }

            // System.out.print(curr+" --> "+next+" ,");

            if(sb.length() > k)
            {
                return;
            }
            if(curr == 'z')
            {
                sb.append('a');
            }else{
                // System.out.println((char)(curr+1));
                sb.append((char)(curr+1));
            }
        }

        helper(k,sb);
    }
    public char kthCharacter(int k) {

        if(k==1)
        {
            return 'a';
        }

        StringBuilder sb = new StringBuilder();
        sb.append('a');

        helper(k,sb);

        return sb.charAt(k-1);
        
    }
}

//                                           a
// a-> b =                                   ab
// a->b,b->c =                               abbc
// a->b,b->c,b->c,c->d =                     abbcbccd
// a->b,b->c,b->c,c->d,b->c,c->d,c->d,d->e = abbcbccdbccdcdbe 

