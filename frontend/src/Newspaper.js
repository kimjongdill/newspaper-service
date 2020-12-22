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
                    <button className="button" onClick={this.randomMode}>Random</button>
                    <button className="button" onClick={this.latestMode}>Latest</button>
                    Serving Niles, Buchanan and Edwardsburg
                </div>
                <div className="banner">
                    Niles Daily Star
                </div>
                <div className="headline">
                    <h2>{this.state.story?.title?.rendered}</h2>
                    <p>{date.toLocaleDateString("en-US", dateOptions)}</p>
                </div>
                <div className="story">
                    {this.state.story?.jetpack_featured_media_url ?
                        <div className="picture"><img src={this.state.story?.jetpack_featured_media_url}></img></div>
                        : ""
                    }
                    <div dangerouslySetInnerHTML={{
                            __html: this.state.story?.content?.rendered
                        }}></div>
                </div>
            </div>
        )
    }
}

export default Newspaper