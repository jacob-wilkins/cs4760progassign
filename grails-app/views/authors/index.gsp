<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="site"/>
    <title>Book Store Authors</title>
</head>

<body>
    <h1> AUTHORS </h1>
    <ul>
        <g:each in="${authorList}" >
            <li>${it.name}<br />
                <ul>
                    <g:each in="${it.books}">
                        <li>&emsp;${it}</li>
                    </g:each>
                </ul>
            </li>
        </g:each>
    </ul>
</body>
</html>
