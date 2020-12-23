import React from 'react';

class Newspaper extends React.Component {

    
    constructor(props){
        super(props)
        this.latest = "http://localhost:8080/latest";
        this.random = "http://localhost:8080/random";
        this.state = {
            mode: this.latest,
            story: {},
        }

        this.randomMode = this.randomMode.bind(this);
        this.latestMode = this.latestMode.bind(this);
        
        this.loadText = (url) => { 
            fetch(url, 
                {mode: "cors",
                 method: "GET"})
                .then( response => response.json())
                .then( json => this.setState({story: json}));    
        }
    }

    randomMode = () => {
        this.loadText(this.random);
    }

    latestMode = () => {
        this.loadText(this.latest);
    }
    async componentDidMount() { 
        this.latestMode();
    }

    render() {
        const dateOptions = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
        let date = new Date(this.state.story?.date);
        
        return(
            <div className="frontPage">
                <div className="stripe">
                    <div className="date">
                        {date.toLocaleDateString("en-US", dateOptions) + "\t\t"}
                    </div>
                    SERVING NILES, BUCHANAN, AND EDWARDSBURG
                </div>
                <div className="banner">
                    Niles Daily Star
                    <div className="buttons">
                        <button className="button" onClick={this.latestMode}>Hot Off The Press</button>
                        <button className="button" onClick={this.randomMode}>Archive</button>
                    </div>
                </div>
                <div className="headline">
                    <h2>{this.state.story?.title?.rendered}</h2>
                </div>
                <div className="story">
                    {this.state.story?.jetpack_featured_media_url ?
                        <div className="picture"><img src={this.state.story?.jetpack_featured_media_url}></img></div>
                        : ""
                    }
                    <div className="byline">
                        <p><b>By CHRISTINA CLARK</b></p>
                        <p>christina.clark@leaderpub.com</p>
                    </div>
                    
                    <div dangerouslySetInnerHTML={{
                            __html: this.state.story?.content?.rendered
                        }}></div>
                </div>
            </div>
        )
    }
}

export default Newspaper