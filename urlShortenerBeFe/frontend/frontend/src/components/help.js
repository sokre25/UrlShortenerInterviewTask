import React from 'react'
class Help extends React.Component {
  render() {
    return (<div>
<h1>Url shortener - interview task</h1>
<p>HTTP service that serves to shorten URLs, with the following functionalities:<br />&bull; Registration Web address (API)<br />&bull; Redirect client in accordance with the shortened URL<br />&bull; Usage Statistics (API)</p>
<p>The whole task scope and api&nbsp;endpoints description&nbsp;can be found in the&nbsp;project repository (file KC assignment - URL shortener_EN.pdf)</p>
<p>&nbsp;</p>
<h3>RUN THE APPLICATION:</h3>
<p>This application has two parts -&gt; Backend part (Spring boot) and frontend part(react JS).</p>
<p>To start the application, follow the steps below:<br />&nbsp; 1. Clone the repository.<br />&nbsp; 2. Go to urlShortenerBefe/url-shortener-task directory<br />&nbsp; 3. Run -&gt; "mvn spring-boot: run" -&gt; application should run on localhost:8080</p>
<p>&nbsp;</p>
<p>Note: Frontend part of the code can be seen if you go to frontend directory.</p>
<p>&nbsp;</p>
<h3>TESTING FUNCTIONALITY</h3>
<p>The whole application functionality can be tested with some&nbsp;API development environment (e.g. Postman), but also can be tested through simple UI.</p>
<p>&nbsp;</p>
<p>On home page (localhost:8080) you have 5 link.</p>
<ul>
<li>Home - contains hello message</li>
<li>Help - page with information how to use the application.</li>
<li>Create Acoount&nbsp;- page for creating user account.</li>
<li>Registar&nbsp;url&nbsp;- page for register url&nbsp;</li>
<li>Statistic - page for showing statistic</li>
</ul>
<p>If you will use these pages, follow next steps or watch video on this link <a href="https://share.vidyard.com/watch/LrAxysfQhP741yBgbdertD">https://share.vidyard.com/watch/LrAxysfQhP741yBgbdertD</a>:</p>
<p>1. Click on "Create Account" link -&gt; fill &nbsp;account id field and click on the submit button. You will get password as a response.</p>
<p>2. Click on "Register url" link -&gt; fill account id, password and url field and click on the submit button. You will get your shortener url&nbsp;as a response.</p>
<p>3.&nbsp;Click on "Statistic" link -&gt; fill account id, password and click on the submit button. You will get statistic data as a response in table view.</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
    </div>);
  }
}
export default Help