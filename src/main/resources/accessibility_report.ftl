<!DOCTYPE html>
<html>
<head>
    <title>Accessibility Report</title>
    <style>
        body {
            font-family: sans-serif;
        }

        h2, h3 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
            text-align: left;
        }

        .violation-details {
            display: none;
        }

        /* Initially hide details */
        .impact-serious {
            color: red;
        }

        .impact-moderate {
            color: orange;
        }

        .impact-minor {
            color: #888;
        }
    </style>
</head>
<body>
<h2>Accessibility Report</h2>
<p>Generated on: ${timestamp?datetime}</p>

<h3>Summary</h3>
<ul>
    <li>Total Violations: ${violationCount}</li>
    <li>Total Elements Affected: ${totalNodes}</li>
</ul>

<h3>Violations</h3>
<table>
    <thead>
    <tr>
        <th>Impact</th>
        <th>Description</th>
        <th>Details</th>
    </tr>
    </thead>
    <tbody>
    <#list axeResults.violations as violation>
        <tr>
            <td class="impact-${violation.impact}">${violation.impact}</td>
            <td>${violation.description}</td>
            <td>
                <button class="show-details">Show Details</button>
                <div class="violation-details">
                    <#list violation.nodes as node>
                        <h4>Target: ${node.target?join(", ")}</h4>
                        <pre>${node.html}</pre>
                    </#list>
                </div>
            </td>
        </tr>
    </#list>
    </tbody>
</table>

<script>
    const showDetailsButtons = document.querySelectorAll(".show-details");
    showDetailsButtons.forEach(button => {
        button.addEventListener("click", () => {
            const details = button.nextElementSibling;
            details.style.display = details.style.display === "none" ? "block" : "none";
        });
    });
</script>
</body>
</html>
