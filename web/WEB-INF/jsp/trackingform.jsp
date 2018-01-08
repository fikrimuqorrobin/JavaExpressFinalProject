
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="https://cdn3.iconfinder.com/data/icons/purchases-and-sales/512/transpo.png">
        <title>JSP Page</title>
    </head>
    <style> 
        input[type=text] {
            width: 200px;
            box-sizing: border-box;
            border: 2px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            background-color: white;
            background-image: url('searchicon.png');
            background-position: 30px 10px; 
            background-repeat: no-repeat;
            padding: 12px 20px 12px 40px;
            -webkit-transition: width 6s ease-in-out;
            transition: width 0.90s ease-in-out;
        }

        input[type=text]:focus {
            width: 70%;
        }

        table {  
            color: #333;
            font-family: Helvetica, Arial, sans-serif;
            width: inherit; 
            border-collapse: 
                collapse; border-spacing: 0; 
        }

        td, th {  
            border: 1px solid transparent; /* No more visible border */
            height: 30px; 
            transition: all 0.3s;  /* Simple transition for hover effect */
        }

        th {  
            border: 1px solid #ddd  ;
            background: #DFDFDF;  /* Darken header a bit */
            font-weight: bold;
            text-align: center;
        }

        td {  
            background: #FAFAFA;
            text-align: center;
        }

        /* Cells in even rows (2,4,6...) are one color */        
        tr:nth-child(even) td { background: #F1F1F1; }   

        /* Cells in odd rows (1,3,5...) are another (excludes header cells)  */        
        tr:nth-child(odd) td { background: #FEFEFE; }  

        tr td:hover { background: #666; color: #FFF; }  
        /* Hover cell effect! */

    </style>
</head>
<body>



    <div class="container">
        <p>Tracking</p>
        <form>
            <input type="text" name="search" placeholder="Masukkan No.Resi">

        </form>
        <a href="${pageContext.request.contextPath}/Tracking/trackingresult"><button type="submit"><i class="fa fa-search"></i></button></a> <br><br><br><br>

        
        

    </div>
</body>
</html>
